package com.snsystems;

import com.snsystems.model.CompanyWrapper;
import com.snsystems.model.PersonData;
import com.snsystems.model.Team;
import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.SparkSession;

public class Main {
    public static void main(String[] args) {
        SparkSession spark = SparkSession.builder()
                .master("local[*]")
                .appName("Spark Test")
                .getOrCreate();

        Dataset<PersonData> df = spark.read()
                .option("header", "true")
                .option("delimiter", ",")
                .csv("src/main/resources/data/person-data.csv")
                .as(Encoders.bean(PersonData.class));

//        df.show();

        Dataset<CompanyWrapper> companyWrapperDataset = df.map((MapFunction<PersonData, CompanyWrapper>) personData -> {
            Team<PersonData> team = new Team<>("TEAM NAME", personData);
            return new CompanyWrapper("COMPANY NAME", team);
        }, Encoders.bean(CompanyWrapper.class));

        companyWrapperDataset.show(false);

    }
}