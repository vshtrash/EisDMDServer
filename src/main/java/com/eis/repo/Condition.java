package com.eis.repo;


public class Condition {


    public TypeForComparsion type;
    public ComparsionJpa comparison;

    public Object value;

    public String field;

    public Condition() {
    }

    public Condition(TypeForComparsion type, ComparsionJpa comparison, Object value, String field) {
        this.type = type;
        this.comparison = comparison;
        this.value = value;
        this.field = field;
    }

    public static class Builder {
        private TypeForComparsion type;
        private ComparsionJpa comparison;
        private Object value;
        private String field;

        public Builder setType(TypeForComparsion type) {
            this.type = type;
            return this;
        }

        public Builder setComparison(ComparsionJpa comparison) {
            this.comparison = comparison;
            return this;
        }

        public Builder setValue(Object value) {
            this.value = value;
            return this;
        }

        public Builder setField(String field) {
            this.field = field;
            return this;
        }

        public Condition build() {
            return new Condition(type, comparison, value, field);
        }
    }
}