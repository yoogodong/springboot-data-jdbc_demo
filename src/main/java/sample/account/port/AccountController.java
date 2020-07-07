package sample.account.port;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sample.account.AccountService;
import sample.common.Out;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }


    @PostMapping
    public Out open(@RequestBody AccountOpenIn in) {
        Long id = service.open(in.getDescription());
        return Out.successOf(new AccountOpenOut(id));
    }

}
