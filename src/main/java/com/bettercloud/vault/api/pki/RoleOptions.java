package com.bettercloud.vault.api.pki;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>A container for options sent to and returned by role-related endpoints on the PKI backend.  This class is
 * meant for use with a builder pattern style.  Example usage:</p>
 *
 * <blockquote>
 * <pre>{@code
 * final RoleOptions options = new RoleOptions()
 *                              .allowedDomains(new ArrayList<String>(){{ add("myvault.com"); }})
 *                              .allowSubdomains(true)
 *                              .maxTtl("9h");
 * }</pre>
 * </blockquote>
 */
public class RoleOptions {

    private String ttl;
    private String maxTtl;
    private Boolean allowLocalhost;
    private List<String> allowedDomains;
    private Boolean allowBareDomains;
    private Boolean allowSubdomains;
    private Boolean allowAnyName;
    private Boolean enforceHostnames;
    private Boolean allowIpSans;
    private Boolean serverFlag;
    private Boolean clientFlag;
    private Boolean codeSigningFlag;
    private Boolean emailProtectionFlag;
    private String keyType;
    private Long keyBits;
    private Boolean useCsrCommonName;

    /**
     * (optional) The Time To Live value provided as a string duration with time suffix. Hour is the largest suffix.
     * If not set, uses the system default value or the value of max_ttl, whichever is shorter.
     *
     * @param ttl
     * @return
     */
    public RoleOptions ttl(final String ttl) {
        this.ttl = ttl;
        return this;
    }

    /**
     * (optional) The maximum Time To Live provided as a string duration with time suffix. Hour is the largest suffix.
     * If not set, defaults to the system maximum lease TTL.
     *
     * @param maxTtl
     * @return
     */
    public RoleOptions maxTtl(final String maxTtl) {
        this.maxTtl = maxTtl;
        return this;
    }

    /**
     * (optional) If set, clients can request certificates for localhost as one of the requested common names. This is
     * useful for testing and to allow clients on a single host to talk securely. Defaults to true.
     *
     * @param allowLocalhost
     * @return
     */
    public RoleOptions allowLocalhost(final Boolean allowLocalhost) {
        this.allowLocalhost = allowLocalhost;
        return this;
    }

    /**
     * (optional) Designates the domains of the role, provided as a comma-separated list. This is used with the
     * allow_bare_domains and allow_subdomains options. There is no default.
     *
     * @param allowedDomains
     * @return
     */
    public RoleOptions allowedDomains(final List<String> allowedDomains) {
        if (allowedDomains != null) {
            this.allowedDomains = new ArrayList<>();
            this.allowedDomains.addAll(allowedDomains);
        }
        return this;
    }

    /**
     * (optional) If set, clients can request certificates matching the value of the actual domains themselves;
     * e.g. if a configured domain set with allowed_domains is example.com, this allows clients to actually request a
     * certificate containing the name example.com as one of the DNS values on the final certificate. In some
     * scenarios, this can be considered a security risk. Defaults to false.
     *
     * @param allowBareDomains
     * @return
     */
    public RoleOptions allowBareDomains(final Boolean allowBareDomains) {
        this.allowBareDomains = allowBareDomains;
        return this;
    }

    /**
     * (optional) If set, clients can request certificates with CNs that are subdomains of the CNs allowed by the other
     * role options. This includes wildcard subdomains. For example, an allowed_domains value of example.com with this
     * option set to true will allow foo.example.com and bar.example.com as well as *.example.com. This is redundant
     * when using the allow_any_name option. Defaults to false.
     *
     * @param allowSubdomains
     * @return
     */
    public RoleOptions allowSubdomains(final Boolean allowSubdomains) {
        this.allowSubdomains = allowSubdomains;
        return this;
    }

    /**
     * (optional) If set, clients can request any CN. Useful in some circumstances, but make sure you understand
     * whether it is appropriate for your installation before enabling it. Defaults to false.
     *
     * @param allowAnyName
     * @return
     */
    public RoleOptions allowAnyName(final Boolean allowAnyName) {
        this.allowAnyName = allowAnyName;
        return this;
    }

    /**
     * (optional) If set, only valid host names are allowed for CNs, DNS SANs, and the host part of email addresses.
     * Defaults to true.
     *
     * @param enforceHostnames
     * @return
     */
    public RoleOptions enforceHostnames(final Boolean enforceHostnames) {
        this.enforceHostnames = enforceHostnames;
        return this;
    }

    /**
     * (optional) If set, clients can request IP Subject Alternative Names. No authorization checking is performed
     * except to verify that the given values are valid IP addresses. Defaults to true.
     *
     * @param allowIpSans
     * @return
     */
    public RoleOptions allowIpSans(final Boolean allowIpSans) {
        this.allowIpSans = allowIpSans;
        return this;
    }

    /**
     * (optional) If set, certificates are flagged for server use. Defaults to true.
     *
     * @param serverFlag
     * @return
     */
    public RoleOptions serverFlag(final Boolean serverFlag) {
        this.serverFlag = serverFlag;
        return this;
    }

    /**
     * (optional) If set, certificates are flagged for client use. Defaults to true.
     *
     * @param clientFlag
     * @return
     */
    public RoleOptions clientFlag(final Boolean clientFlag) {
        this.clientFlag = clientFlag;
        return this;
    }

    /**
     * (optional) If set, certificates are flagged for code signing use. Defaults to false.
     *
     * @param codeSigningFlag
     * @return
     */
    public RoleOptions codeSigningFlag(final Boolean codeSigningFlag) {
        this.codeSigningFlag = codeSigningFlag;
        return this;
    }

    /**
     * (optional) If set, certificates are flagged for email protection use. Defaults to false.
     *
     * @param emailProtectionFlag
     * @return
     */
    public RoleOptions emailProtectionFlag(final Boolean emailProtectionFlag) {
        this.emailProtectionFlag = emailProtectionFlag;
        return this;
    }

    /**
     * (optional) The type of key to generate for generated private keys. Currently, rsa and ec are supported.
     * Defaults to rsa.
     *
     * @param keyType
     * @return
     */
    public RoleOptions keyType(final String keyType) {
        this.keyType = keyType;
        return this;
    }

    /**
     * (optional) The number of bits to use for the generated keys. Defaults to 2048; this will need to be changed
     * for ec keys. See https://golang.org/pkg/crypto/elliptic/#Curve for an overview of allowed bit lengths for ec.
     *
     * @param keyBits
     * @return
     */
    public RoleOptions keyBits(final Long keyBits) {
        this.keyBits = keyBits;
        return this;
    }

    /**
     * (optional) If set, when used with the CSR signing endpoint, the common name in the CSR will be used instead
     * of taken from the JSON data. This does not include any requested SANs in the CSR. Defaults to false.
     *
     * @param useCsrCommonName
     * @return
     */
    public RoleOptions useCsrCommonName(final Boolean useCsrCommonName) {
        this.useCsrCommonName = useCsrCommonName;
        return this;
    }

    public String getTtl() {
        return ttl;
    }

    public String getMaxTtl() {
        return maxTtl;
    }

    public Boolean getAllowLocalhost() {
        return allowLocalhost;
    }

    public List<String> getAllowedDomains() {
        if (allowedDomains == null) {
            return null;
        } else {
            final List<String> clone = new ArrayList<>();
            clone.addAll(allowedDomains);
            return allowedDomains;
        }
    }

    public Boolean getAllowBareDomains() {
        return allowBareDomains;
    }

    public Boolean getAllowSubdomains() {
        return allowSubdomains;
    }

    public Boolean getAllowAnyName() {
        return allowAnyName;
    }

    public Boolean getEnforceHostnames() {
        return enforceHostnames;
    }

    public Boolean getAllowIpSans() {
        return allowIpSans;
    }

    public Boolean getServerFlag() {
        return serverFlag;
    }

    public Boolean getClientFlag() {
        return clientFlag;
    }

    public Boolean getCodeSigningFlag() {
        return codeSigningFlag;
    }

    public Boolean getEmailProtectionFlag() {
        return emailProtectionFlag;
    }

    public String getKeyType() {
        return keyType;
    }

    public Long getKeyBits() {
        return keyBits;
    }

    public Boolean getUseCsrCommonName() {
        return useCsrCommonName;
    }

}
