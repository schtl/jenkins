/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.kaindorf.plf1.examdb.database;

import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author spamac15
 */
@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDate, java.sql.Date>{

    @Override
    public Date convertToDatabaseColumn(LocalDate ld) {
       return Date.valueOf(ld);}

    @Override
    public LocalDate convertToEntityAttribute(Date date) {
       return date.toLocalDate(); }
    
}
