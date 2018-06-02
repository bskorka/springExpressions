package pl.bskorka.springExpressions;

public class TestyClassy {

    public enum State {
        REGISTERED("R"),
        EXECUTED("W"),
        FINISHED("Z");

        String value;

        State(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        public static State parse(String value) {
            for (State state : State.values()) {
                if (state.getValue().equals(value))
                    return state;
            }

            throw new IllegalArgumentException("There is no enum for passed value: " + value);
        }

    }

}
