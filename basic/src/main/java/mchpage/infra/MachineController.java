package mchpage.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import mchpage.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping(value="/machines")
@Transactional
public class MachineController {

    @Autowired
    MachineRepository machineRepository;

    @PutMapping("/machines/search/findByMchCd")
    public Object findByMchCd(@RequestBody MachineViewQuery query) {
        return machineRepository.findByMchCd(query.getMchCd());
    }
}
