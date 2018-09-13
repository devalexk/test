package edu.olezha.jsandbox.model;

import lombok.Value;

import java.util.List;

@Value
public class Foo {

    String name;

    List<Bar> barList;
}
