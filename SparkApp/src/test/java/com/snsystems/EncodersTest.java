package com.snsystems;

import com.snsystems.model.CompanyWrapper;
import com.snsystems.model.PersonData;
import com.snsystems.model.Team;
import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.junit.Test;

import java.util.NoSuchElementException;

public class EncodersTest {

    @Test (expected = IllegalStateException.class)
    public void encodeBeanRow()  {
        SparkSession spark = SparkSession.builder()
                .master("local[*]")
                .appName("Spark Test")
                .getOrCreate();

        Dataset<Row> rowDataset = spark.read()
                .option("header", "true")
                .option("delimiter", ",")
                .csv("src/main/resources/data/person-data.csv")
                .as(Encoders.bean(Row.class));

        rowDataset.show();
    }

    @Test
    public void encodeBeanPersonData() {
        SparkSession spark = SparkSession.builder()
                .master("local[*]")
                .appName("Spark Test")
                .getOrCreate();

        Dataset<PersonData> personDataDataset = spark.read()
                .option("header", "true")
                .option("delimiter", ",")
                .csv("src/main/resources/data/person-data.csv")
                .as(Encoders.bean(PersonData.class));

        personDataDataset.show();
    }

    @Test (expected = NoSuchElementException.class)
    public void encodeBean() {
        SparkSession spark = SparkSession.builder()
                .master("local[*]")
                .appName("Spark Test")
                .getOrCreate();

        Dataset<PersonData> personDataDataset = spark.read()
                .option("header", "true")
                .option("delimiter", ",")
                .csv("src/main/resources/data/person-data.csv")
                .as(Encoders.bean(PersonData.class));

        // personDataDataset.show();

        Dataset<CompanyWrapper> companyWrapperDataset =
                personDataDataset.map(
                        (MapFunction<PersonData, CompanyWrapper>) personData -> {
            Team<PersonData> team = new Team<>("TEAM NAME", personData);
            return new CompanyWrapper("COMPANY NAME", team);
        }, Encoders.bean(CompanyWrapper.class));

        companyWrapperDataset.show(false);
    }

}
