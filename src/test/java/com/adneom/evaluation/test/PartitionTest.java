package com.adneom.evaluation.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.adneom.evaluation.CustomException;
import com.adneom.evaluation.Partition;


/**
 * Unit test for simple App.
 */
public class PartitionTest{

	static int i = 1;
    
    @BeforeEach
    void init() {
        System.out.println("le test numéro "+ i++ +" sera lancé ");
    }   
    
    
    
    @DisplayName("Test unitaire: retour de la méthode compartiment")
    @Test
    void testTypeReturn() throws NullPointerException, CustomException {

    	final ArrayList<Integer> listInput = new ArrayList<Integer>();		
    	listInput.add(1);
		listInput.add(2);
		listInput.add(3);
		listInput.add(4);
		listInput.add(5);
		listInput.add(6);
    	final List<List<Integer>> listOutput = Partition.compartiment(listInput, 6);
    	
    	assertEquals(listOutput.getClass(), ArrayList.class);
    }
    
    @DisplayName("Test unitaire: méthode compartiment")
    @Test
    void testCompartiment() throws NullPointerException, CustomException {

    	final ArrayList<Integer> listInput = new ArrayList<Integer>();		
    	final List<List<Integer>> manualListOutput = new ArrayList<List<Integer>>();
    	
		listInput.add(1);
		listInput.add(2);
		listInput.add(3);
		listInput.add(4);
		listInput.add(5);
		listInput.add(6);
		manualListOutput.add(listInput);
    	
    	final List<List<Integer>> compartiment = Partition.compartiment(listInput, 6);
    	assertEquals(compartiment, manualListOutput);
    	
    }
    
    
    
}
