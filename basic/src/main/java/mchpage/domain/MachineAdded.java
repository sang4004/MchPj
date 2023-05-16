package mchpage.domain;

import java.util.*;
import lombok.*;
import mchpage.domain.*;
import mchpage.infra.AbstractEvent;

@Data
@ToString
public class MachineAdded extends AbstractEvent {

    private Long id;
    private String mchCd;
    private String mchNm;
    private String mchMd;
    private String mchSize;

    public MachineAdded(Machine aggregate) {
        super(aggregate);
    }

    public MachineAdded() {
        super();
    }
}
