package br.com.vyne.domain.enums;

public enum CurrencyEnum {
	USD(0, "Dollar"),
	GBP(1, "Pound sterling"),
    NOT_IDENTIFIED(-1, "Not identified");

    private Integer value;
    private String description;

    CurrencyEnum(Integer value, String description) {
        this.value = value;
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public Integer getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.description;
    }

    public static CurrencyEnum fromValue(Integer cod) {
        for (CurrencyEnum b : CurrencyEnum.values()) {
            if (b.value.equals(cod)) {
                return b;
            }
        }

        return CurrencyEnum.NOT_IDENTIFIED;
    }
}