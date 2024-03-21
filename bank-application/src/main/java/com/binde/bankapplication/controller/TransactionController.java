package com.binde.bankapplication.controller;

import com.binde.bankapplication.entity.Transaction;
import com.binde.bankapplication.service.impl.BankStatement;
import com.itextpdf.text.*;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

@RestController
@RequestMapping("/bankStatement")
@AllArgsConstructor
@Slf4j
public class TransactionController {
 private BankStatement bankStatement;
 private static final String FILE ="/macbook/desktop/statement.pdf";
 @GetMapping
 public List<Transaction> generateBankStatement(@RequestParam String accountNumber,
                                                @RequestParam String startDate,
                                                @RequestBody String endDate) throws DocumentException, FileNotFoundException {
  return bankStatement.generateStatement(accountNumber,startDate,endDate);

 }

}
