package com.binde.bankapplication.service.impl;

import com.binde.bankapplication.dto.EmailDetails;
import com.binde.bankapplication.entity.Transaction;
import com.binde.bankapplication.entity.User;
import com.binde.bankapplication.repository.TransactionRepository;
import com.binde.bankapplication.repository.UserRepository;
import com.binde.bankapplication.service.EmailService;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.itextpdf.text.Annotation.FILE;

@Service
@AllArgsConstructor
@Slf4j
public class BankStatement {
    private TransactionRepository transactionRepository;
    private UserRepository userRepository;
    private EmailService emailService;
    //retrieve a list of transactions within date range
    //generate a pdf file transactions
    //send the file via email
    public List<Transaction> generateStatement(String accountNumber, String startDate, String endDate) throws DocumentException, FileNotFoundException {
        LocalDate start = LocalDate.parse(startDate, DateTimeFormatter.ISO_DATE);
        LocalDate end = LocalDate.parse(endDate,DateTimeFormatter.ISO_DATE);
        List<Transaction> transactionList = transactionRepository.findAll().stream().filter(transaction -> transaction.getAccountNumber().equals(accountNumber))
                .filter(transaction -> transaction.getCreatedAt().isEqual(start)).filter(transaction -> transaction.getCreatedAt().isEqual(end)).toList();
        User user = userRepository.findByAccountNumber(accountNumber);
        String customerName = user.getFirstName() + " " + user.getLastName() + " " + user.getOtherName();
        Rectangle statementSize = new Rectangle(PageSize.A4);
        Document document = new Document(statementSize);
        log.info(" setting size of document");
        OutputStream outputStream = new FileOutputStream(FILE);
        PdfWriter.getInstance(document,outputStream);
        document.open();

        PdfPTable bankInfoTable = new PdfPTable(1);
        PdfPCell bankName = new PdfPCell(new Phrase("The UBA bank transaction statement"));
        bankName.setBorder(0);
        bankName.setBackgroundColor(BaseColor.BLUE);
        bankName.setPadding(20f);


        PdfPCell bankAddress = new PdfPCell(new Phrase("21, Rwang Pam Street Jos"));
        bankAddress.setBorder(0);
        bankInfoTable.addCell(bankName);
        bankInfoTable.addCell(bankAddress);


        PdfPTable statementInfo = new PdfPTable(2);
        PdfPCell customerInfo = new PdfPCell(new Phrase("Start Date :" + startDate));
        customerInfo.setBorder(0);
        PdfPCell statement = new PdfPCell(new Phrase("STATEMENT OF ACCOUNT"));
        statement.setBorder(0);
        PdfPCell stopDate = new PdfPCell(new Phrase("End Date :" + endDate));
        stopDate.setBorder(0);
        PdfPCell name = new PdfPCell(new Phrase("CustomerName :" + customerName));
        name.setBorder(0);

        PdfPCell space = new PdfPCell(new Phrase());
        space.setBorder(0);
        PdfPCell address = new PdfPCell(new Phrase("Customer Address :" + user.getAddress()));
        address.setBorder(0);

       PdfPTable transactionsTable = new PdfPTable(4);
       PdfPCell date = new PdfPCell(new Phrase("DATE"));
       date.setBackgroundColor(BaseColor.BLUE);
       date.setBorder(0);
       PdfPCell transactionType = new PdfPCell(new Phrase("TRANSACTION TYPE"));
       transactionType.setBackgroundColor(BaseColor.BLUE);
       transactionType.setBorder(0);

       PdfPCell transactionsAmount = new PdfPCell(new Phrase("AMOUNT"));
       transactionsAmount.setBackgroundColor(BaseColor.BLUE);
       transactionsAmount.setBorder(0);
       PdfPCell status = new PdfPCell(new Phrase("STATUS"));
       status.setBackgroundColor(BaseColor.BLUE);
       status.setBorder(0);
       transactionsTable.addCell(date);
       transactionsTable.addCell(transactionType);
       transactionsTable.addCell(transactionsAmount);
       transactionsTable.addCell(status);

       transactionList.forEach(transaction ->
       {
           transactionsTable.addCell(new Phrase(transaction.getCreatedAt().toString()));
           transactionsTable.addCell(new Phrase(transaction.getTransactionType()));
           transactionsTable.addCell(transaction.getAmount().toString());
           transactionsTable.addCell(new Phrase(transaction.getStatus()));
       });
       statementInfo.addCell(customerInfo);
       statementInfo.addCell(statement);
       statementInfo.addCell(endDate);
       statementInfo.addCell(name);
       statementInfo.addCell(space);
       statementInfo.addCell(address);

       document.add(bankInfoTable);
       document.add(statementInfo);
       document.add(transactionsTable);

       document.close();

        EmailDetails emailDetails = EmailDetails.builder()
                .recipient(user.getEmail())
                .subject("STATEMENT OF ACCOUNT")
                .messageBody("kindly find your account statement details attachment")
                .attachment(FILE)
                .build();
        emailService.sendEmailWithAttachment(emailDetails);



        return transactionList;
    }
}
