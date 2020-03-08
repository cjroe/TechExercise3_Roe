package datamodel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name= "Card")
public class Card {
	
	@Id
	@GeneratedValue()
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="type")
	private String type;
	@Column(name="mana")
	private int mana;
	@Column(name="cardColor")
	private String cardColor;
	@Column(name="rules")
	private String rules;
	
	
	public Card() {
		
	}

	public Card(String name, String type, String cardColor, int mana, String rules) {
		this.name = name;
		this.type = type;
		this.cardColor = cardColor;
		this.mana = mana;
		this.rules = rules;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getMana() {
		return mana;
	}
	public void setMana(int mana) {
		this.mana = mana;
	}
	public String getCardColor() {
		return cardColor;
	}
	public void setCardColor(String cardColor) {
		this.cardColor = cardColor;
	}
	
	public String getRules() {
		return rules;
	}
	public void setRules(String rules) {
		this.rules = rules;
	}
	@Override
	public String toString() {
		
		return String.format("Card #%d:\n Name: %s\n Type: %s\n Color: %s\n Mana Cost: %d\n Rules: %s ",
					this.id, this.name, this.type, this.cardColor, this.mana,this.rules);
	}
}
