package com.adneom.evaluation;

import java.util.ArrayList;
import java.util.List;

public class Partition {
	
	private List<Integer> listInput = new ArrayList<Integer>();
	private int size;
	
	public List<Integer> getListInput() {
		return listInput;
	}

	public void setListInput(List<Integer> listInput) {
		this.listInput = listInput;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public Partition(List<Integer> listInput, int size) {
		super();
		this.listInput = listInput;
		this.size = size;
	}

	/**
	 * Partionnement d'une liste en sous listes d'entiers selon un paramètre 
	 * @param listInput
	 * @param size
	 * @return List<List<Integer>>
	 * @throws TailleDepasserException 
	 */
	public static List<List<Integer>> compartiment(final List<Integer> listInput, final int size) throws CustomException, NullPointerException{

		int it = 0 , tempSize = size;
		final List<List<Integer>> listOutput = new ArrayList<List<Integer>>();
		
		if (size == 0) throw new CustomException("Attention la taille du compartiment doit être > 0");

		try {
			while ( tempSize <= listInput.size()) {			
				listOutput.add(listInput.subList(it, tempSize));
				it = tempSize;
				tempSize = it + size;
			}
		if (!listInput.subList(it, listInput.size()).isEmpty()) listOutput.add(listInput.subList(it, listInput.size()));
		}catch(NullPointerException e) {
			throw new NullPointerException("Veuillez initialiser la liste "+e.getMessage() + " et pour cause "+e.getClass());
		}
		return listOutput;
	}

	public static void main(String[] args) {

		ArrayList<Integer> listInput = new ArrayList<Integer>();		
		listInput.add(1);
		listInput.add(2);
		listInput.add(3);
		listInput.add(4);
		listInput.add(5);
		listInput.add(6);
		Partition partition = new Partition(listInput, 3);
		
			try {
				System.out.println("Liste avant partition :"+listInput+" Liste après partition :" 
				+Partition.compartiment(partition.getListInput(), partition.getSize()));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

	}
}
