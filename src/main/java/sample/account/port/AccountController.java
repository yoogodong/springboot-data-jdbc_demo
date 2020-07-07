package sample.account.port;

import org.springframework.web.bind.annotation.*;
import sample.account.Account;
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


    @GetMapping
    public Out listAll() {
        Iterable<Account> accounts = service.listAll();
        return Out.successOf(accounts);
    }
}
