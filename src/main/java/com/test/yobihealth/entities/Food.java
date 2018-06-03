package com.test.yobihealth.entities;

public class Food {
	
	private String id;
	private String titre;
	private String description;
	private String ingredient;
	
	
	
	
	
	
	public Food(String titre, String description, String ingredient) {
		super();
		this.titre = titre;
		this.description = description;
		this.ingredient = ingredient;
	}
	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Food(String id, String titre, String description, String ingredient) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.ingredient = ingredient;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIngredient() {
		return ingredient;
	}
	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}
	
	

}
