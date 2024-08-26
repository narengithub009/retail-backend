package com.retail.app.util;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix = "app")
//@ConstructorBinding
@Validated

public class ApplicationProperties {

    /*private String version;
    private FtpProperties ftp;*/
    private final String version;
    private final FtpProperties ftp;

    public ApplicationProperties(String version, FtpProperties ftp) {
        this.version = version;
        this.ftp = ftp;
    }

    public String getVersion() {
        return version;
    }

    /*public void setVersion(String version) {
        this.version = version;
    }*/

    public FtpProperties getFtp() {
        return ftp;
    }

    /*public void setFtp(FtpProperties ftp) {
        this.ftp = ftp;
    }
*/

    @Override
    public String toString() {
        return "ApplicationProperties{" +
                "version='" + version + '\'' +
                ", ftp=" + ftp +
                '}';
    }

    public static class FtpProperties{
        @NotEmpty
       /*private String host;
        @Positive
       private int port;
        @NotEmpty
       private String username;
        @NotEmpty
       private String password;*/

        private final String host;
        @Positive
        private final int port;
        @NotEmpty
        private final String username;
        @NotEmpty
        private final String password;

        public FtpProperties(String host, int port, String username, String password) {
            this.host = host;
            this.port = port;
            this.username = username;
            this.password = password;
        }

        public String getHost() {
            return host;
        }

        /*public void setHost(String host) {
            this.host = host;
        }*/

        public int getPort() {
            return port;
        }

        /*public void setPort(int port) {
            this.port = port;
        }*/

        public String getUsername() {
            return username;
        }

        /*public void setUsername(String username) {
            this.username = username;
        }*/

        public String getPassword() {
            return password;
        }

       /* public void setPassword(String password) {
            this.password = password;
        }*/

        @Override
        public String toString() {
            return "FtpProperties{" +
                    "host='" + host + '\'' +
                    ", port=" + port +
                    ", username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }
}
