package io.qase.ui.utils;

import com.github.javafaker.Faker;

public class TestData {


    Faker faker = new Faker();

    public String projectName = faker.funnyName().name();
    public String projectCode = faker.bothify("######");
}
