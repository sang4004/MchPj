package mchpage.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import mchpage.BasicApplication;
import mchpage.domain.MachineAdded;
import org.springframework.context.ApplicationContext;

@Entity
@Table(name = "Machine_table")
@Data
public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String mchCd;

    private String mchNm;

    private String mchMd;

    private String mchSize;

    @PostPersist
    public void onPostPersist() {
        MachineAdded machineAdded = new MachineAdded(this);
        machineAdded.publishAfterCommit();
    }

    public static MachineRepository repository() {
        MachineRepository machineRepository = applicationContext()
            .getBean(MachineRepository.class);
        return machineRepository;
    }

    public static ApplicationContext applicationContext() {
        return BasicApplication.applicationContext;
    }
}
