package seedu.address.model.expense;

import static seedu.address.commons.util.AppUtil.checkArgument;

public class Order {

    public static final String MESSAGE_CONSTRAINTS = "The sorting order can only be descending or ascending.\n"
                    + "Please specify again!";

    private final String order;

    /**
     * ConstructS a new order object.
     *
     * @param order The order which is a String.
     */
    public Order(String order) {
        checkArgument(isValidOrder(order), MESSAGE_CONSTRAINTS);
        this.order = order;
    }

    /**
     * Checks whether this Order object is a valid one or not.
     *
     * @return Whether this Order object is a valid one or not.
     */
    public static boolean isValidOrder(String order) {
        return order.equals("ascending") || order.equals("descending");
    }

    /**
     * Gets the order of the Order object.
     *
     * @return The order which is a String.
     */
    public String getOrder() {
        return this.order;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (!(other instanceof Order)) {
            return false;
        }

        return this.order.equals(((Order) other).getOrder());
    }

    /**
     * Checks whether this Order object is a descending one.
     *
     * @return Whether this Order object is a descending one.
     */
    public boolean isDescendingOrder() {
        return this.order.equals("descending");
    }

    /**
     * Checks whether this Order object is a ascending one.
     *
     * @return Whether this Order object is a ascending one.
     */
    public boolean isAscendingOrder() {
        return this.order.equals("ascending");
    }
}

