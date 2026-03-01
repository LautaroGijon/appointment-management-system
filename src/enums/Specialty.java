package enums;

public enum Specialty {

	HAIRDRESSING(12000),
    AESTHETICS(20000),
    BARBERING(15000),
    PHYSIOTHERAPY(25000),
    DERMATOLOGY(20000),
    MASSAGE_THERAPY(30000),
    NUTRITION(15000),
    DENTISTRY(45000);

    private int price;

    Specialty(int price) {
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }
	
}
