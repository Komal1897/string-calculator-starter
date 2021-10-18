package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorShould {
    
    //Test for Empty String
    @Test
     void empty_string_should_return_0() {
     	StringCalculator stringCalculator = new StringCalculator();
     	assertEquals(0, stringCalculator.add(""));
    }
	
    //Test for single number
    @Test
    void string_with_single_number_should_return_number() {
       	 StringCalculator stringCalculator = new StringCalculator();
         assertEquals(1, stringCalculator.add("1"));
    }
    
    //Test for sum of two numbers
    @Test
    void should_return_sum_of_two_numbers() {
    	StringCalculator stringCalculator = new StringCalculator();
         assertEquals(3, stringCalculator.add("1,2"));
    }

    //Test of sum of Unknown amount of numbers
    @Test
    void should_return_sum_of_unknown_amount_of_numbers() {
    	StringCalculator stringCalculator = new StringCalculator();
    	 assertEquals(6, stringCalculator.add("1,2,3"));
    }

    //Test of sum of numbers to handle new lines
    @Test
    void should_return_sum_of_numbers_with_commas_and_new_lines() {
        StringCalculator stringCalculator = new StringCalculator();
         assertEquals(6, stringCalculator.add("1,2\n3"));
         assertEquals(3, stringCalculator.add("1\n2"));
    }
     
    //Test to support different delimiters
    @Test
     void should_return_sum_of_numbers_split_by_custom_delimiter() {
             StringCalculator stringCalculator = new StringCalculator();
             assertEquals(3, stringCalculator.add("//;\n1;2"));
             assertEquals(6, stringCalculator.add("//,\n2,3,1"));
     }
    
    //Test for negative numbers
    @Test
    void should_throws_Exception_On_NegativeNumber() {
            StringCalculator stringCalculator = new StringCalculator();
            assertThrows(IllegalArgumentException.class,()->{
            stringCalculator.add("-3");});
    }
    
   //Test of multiple negative numbers
    @Test
    void should_throws_On_Negative_Numbers_With_All_Numbers_In_ExceptionMessage() {
	    StringCalculator stringCalculator = new StringCalculator();
	    assertThrows(IllegalArgumentException.class,()->{
	    stringCalculator.add("1,-3,5,-5,-13");});
    }
	
    //Test to count no. of times add() was invoked
    @Test
    void should_return_GetCalledCount() throws Exception{
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(6, stringCalculator.add("//[**][%%]\n1**2%%3"));
		assertEquals(6, stringCalculator.add("//[**][%%]\n1**2%%3"));
		assertEquals(1, stringCalculator.add("1"));
		assertEquals(3,stringCalculator.GetCalledCount());
    }
	
    //Test of numbers bigger than 1000
    @Test
    void should_maps_Number_Above_1000_To_Last_Three_Digits(){
        StringCalculator stringCalculator = new StringCalculator();
         assertEquals(2, stringCalculator.add("1002"));
         assertEquals(42, stringCalculator.add("1040,1002"));
    }

   //Test of Delimiters of any length	
   @Test
    void should_accepts_Delimiter_Of_Arbitrary_Length() {
        StringCalculator stringCalculator = new StringCalculator();
         assertEquals(6, stringCalculator.add("//[***]\n1***2***3"));
    }
	
    //Test of Multiple delimiter
    @Test
    void should_accepts_Multiple_Delimiter() {
        StringCalculator stringCalculator = new StringCalculator();
         assertEquals(6, stringCalculator.add("//[*][%]\n1*2%3"));
    }
	
   //Test of Multiple delimiter with length longer than one char
    @Test
    void should_accepts_Multiple_Delimiter_with_length_longer_than_one() {
        StringCalculator stringCalculator = new StringCalculator();
         assertEquals(6, stringCalculator.add("//[**][%%]\n1**2%%3"));

}
