/*
 * Copyright (c) 2014 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.controller.cluster.example.messages;

import java.io.Serializable;

public class KeyValue implements Serializable{
    private final String key;
    private final String value;

    public KeyValue(String key, String value){
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override public String toString() {
        return "KeyValue{" +
            "key='" + key + '\'' +
            ", value='" + value + '\'' +
            '}';
    }
}
