package org.example.tools.abstractions;

import org.example.model.Geography;

import java.util.List;

public interface IHaveHierarchicalStructure<TModel>{


    TModel getParent();
    void setParent(TModel model);
    List<TModel> getChildren();
    int  getId();
    Integer getParentId();
}
