package com.example.productservice;


import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class SampleTestClass {
    @Test
    void testMethod() {
        int i=1+1;

        assert i==2;
    }
}


//Arrange - create the variables/objects required for testing
//Act - Call the required functions
//Assert - check the function output against the expected output

