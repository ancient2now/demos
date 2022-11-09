package com.akikun.demo.spring.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.ldap.query.LdapQuery;
import org.springframework.ldap.query.LdapQueryBuilder;
import org.springframework.ldap.query.SearchScope;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李俊秋(龙泽)
 */
@Service
@Slf4j
public class LdapService {

    @Autowired
    private LdapTemplate ldapTemplate;

    public boolean audit() {
        LdapQuery query = LdapQueryBuilder.query().filter(new EqualsFilter("cn", 17352));
        try {
            ldapTemplate.authenticate(query, "hello");
            return true;
        } catch (Exception e) {
            log.warn("LDAP校验密码失败，cn={}, exception:", 061312, e);
            return false;
        }
    }

    public boolean authenticate(String cn, String password) {
        LdapQuery query = LdapQueryBuilder.query().filter("cn=" + cn);
        try {
            ldapTemplate.authenticate(query, password);
            return true;
        } catch (Exception e) {
            log.warn("LDAP校验密码失败，cn={}, exception:", cn, e);
            return false;
        }
    }

    private List<String> find(String cn, String password) {
        AndFilter filter = new AndFilter();
        filter.and(new EqualsFilter("objectclass", "person"));
        filter.and(new EqualsFilter("cn", cn));
        filter.and(new EqualsFilter("userPassword", password));

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
