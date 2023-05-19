package com.netflix.archaius.persisted2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DefaultPersisted2ClientConfig implements Persisted2ClientConfig {

    private int refreshRate = 30;
    private List<String> prioritizedScopes = new ArrayList<>();
    private Map<String, Set<String>> queryScopes = new HashMap<>();
    private String serviceUrl;
    private Map<String, String> scopes = new HashMap<>();
    private boolean skipPropsWithExtraScopes = false;
    private boolean isEnabled = true;
    private boolean instrumentationEnabled = false;
    
    public DefaultPersisted2ClientConfig withRefreshRate(int refreshRate) {
        this.refreshRate = refreshRate;
        return this;
    }
    
    @Override
    public int getRefreshRate() {
        return refreshRate;
    }

    public DefaultPersisted2ClientConfig withPrioritizedScopes(List<String> scopes) {
        this.prioritizedScopes = scopes;
        return this;
    }
    
    public DefaultPersisted2ClientConfig withPrioritizedScopes(String ... scopes) {
        this.prioritizedScopes = Arrays.asList(scopes);
        return this;
    }
    
    @Override
    public List<String> getPrioritizedScopes() {
        return this.prioritizedScopes;
    }

    public DefaultPersisted2ClientConfig withScope(String name, String value) {
        this.scopes.put(name, value);
        return this;
    }
    
    @Override
    public Map<String, String> getScopes() {
        return scopes;
    }

    public DefaultPersisted2ClientConfig withQueryScope(String name, String ... values) {
        Set<String> unique = new HashSet<>();
        unique.addAll(Arrays.asList(values));
        queryScopes.put(name, unique);
        return this;
    }
    
    @Override
    public Map<String, Set<String>> getQueryScopes() {
        return queryScopes;
    }

    public DefaultPersisted2ClientConfig withServiceUrl(String url) {
        this.serviceUrl = url;
        return this;
    }
    
    @Override
    public String getServiceUrl() {
        return this.serviceUrl;
    }

    public DefaultPersisted2ClientConfig withSkipPropsWithExtraScopes(boolean value) {
        this.skipPropsWithExtraScopes = value;
        return this;
    }
    
    @Override
    public boolean getSkipPropsWithExtraScopes() {
        return skipPropsWithExtraScopes;
    }

    public DefaultPersisted2ClientConfig setEnabled(boolean value) {
        this.isEnabled = value;
        return this;
    }
    
    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

//    public DefaultPersisted2ClientConfig setInstrumentationEnabled(boolean instrumentationEnabled) {
//        this.instrumentationEnabled = instrumentationEnabled;
//        return this;
//    }
//
//    @Override
//    public boolean getInstrumentationEnabled() {
//        return instrumentationEnabled;
//    }

    @Override
    public String toString() {
        return new StringBuilder()
          .append("DefaultPersisted2ClientConfig[")
          .append("url=" + serviceUrl)
          .append(" scopes=" + scopes)
          .append(" priority=" + prioritizedScopes)
          .append(" queryScopes=" + queryScopes)
          .append(" enabled=" + isEnabled)
//          .append(" instrumentationEnabled=" + instrumentationEnabled)
          .append("]")
          .toString();
    }
}
