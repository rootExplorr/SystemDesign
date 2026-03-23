package org.design.fileCompare.source;

import java.util.Iterator;

public interface Source<T> {
    Iterator<T> execute();
}
