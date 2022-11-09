package com.akikun.demo.spring.controller;

import com.akikun.demo.spring.service.LdapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.ldap.query.LdapQuery;
import org.springframework.ldap.query.LdapQueryBuilder;
import org.springframework.ldap.query.SearchScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 李俊秋(龙泽)
 */
@RestController
@RequestMapping("/ldap")
public class LdapController {

    @Autowired
    private LdapService ldapService;

    @Autowired
    private LdapTemplate ldapTemplate;


    @GetMapping("/audit")
    public String audit() {
        ldapService.audit();
        return "ok";
    }

    @GetMapping("/find")
    @ResponseBody
    public List<String> find() {
        AndFilter filter = new AndFilter();
        filter.and(new EqualsFilter("objectclass", "person"));
        filter.and(new EqualsFilter("cn", 10258));
//        filter.and(new EqualsFilter("userPassword", "28211x"));

        LdapQuery ldapQuery = LdapQueryBuilder
                .query()
                .countLimit(1)
                .timeLimit(3000)
                .searchScope(SearchScope.SUBTREE)
                .attributes("cn")
                .filter(filter);
        List<String> result = ldapTemplate.search(ldapQuery, (AttributesMapper<String>) attrs -> (String) attrs.get("cn").get());
        return result;
    }

}
