package iftm.pushnotification.configs;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class FirebaseConfig {

    @Value("${firebase.credential-file-name}")
    private String credentialFileName;

    @Bean
    public FirebaseMessaging firebaseMessaging(final FirebaseApp firebaseApp) {
        return FirebaseMessaging.getInstance(firebaseApp);
    }

    @Bean
    public FirebaseApp firebaseApp(final GoogleCredentials credentiasl) {
        final FirebaseOptions options = FirebaseOptions.builder()
            .setCredentials(credentiasl)
            .build();

        return FirebaseApp.initializeApp(options);
    }

    @Bean
    public GoogleCredentials googleCredentials() throws Exception {
        var classPathResource = new ClassPathResource(credentialFileName).getInputStream();

        return GoogleCredentials.fromStream(classPathResource);
    }
}
