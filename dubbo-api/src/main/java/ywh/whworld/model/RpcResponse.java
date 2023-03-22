package ywh.whworld.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class RpcResponse implements Serializable {
    private String khh;
    private String mm;
}
