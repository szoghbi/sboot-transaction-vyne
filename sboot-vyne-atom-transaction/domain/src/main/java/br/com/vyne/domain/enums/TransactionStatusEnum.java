package br.com.vyne.domain.enums;

public enum TransactionStatusEnum {
	CHECKING(0, "Checking"),
	CONFIRMED(1, "Confirmed transaction"),
    REJECTED(2, "Transaction rejected"),
    NOT_IDENTIFIED(-1, "Not identified");

    private Integer value;
    private String description;

    TransactionStatusEnum(Integer value, String description) {
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

    public static TransactionStatusEnum fromValue(Integer cod) {
        for (TransactionStatusEnum b : TransactionStatusEnum.values()) {
            if (b.value.equals(cod)) {
                return b;
            }
        }

        return TransactionStatusEnum.NOT_IDENTIFIED;
    }
}