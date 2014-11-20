package com.github.aler86.fantacalcio.model;

import java.util.List;


public class ModelList<Child extends Model> extends JsonArray<Child> {

    public ModelList(List<Child> list) {
        super(list);
    }

}