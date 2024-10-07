package org.example.tools;

import org.example.model.Geography;
import org.example.tools.abstractions.IHaveHierarchicalStructure;

import java.util.List;

public class HierarchyBuilder <TItem extends IHaveHierarchicalStructure<TItem>> {

    void setElements(List<TItem> geographies){

    }

    void buildHierarchy(){

    }
    TItem getRootElement(){
        return null;
    }

}
