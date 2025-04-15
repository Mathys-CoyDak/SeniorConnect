CREATE TABLE Utilisateurs (
                              id INT AUTO_INCREMENT PRIMARY KEY,
                              prenom VARCHAR(50) NOT NULL,
                              nom VARCHAR(50) NOT NULL,
                              email VARCHAR(100) NOT NULL UNIQUE,
                              mot_de_passe VARCHAR(255) NOT NULL,
                              type_utilisateur ENUM('senior', 'recruteur', 'admin') NOT NULL,
                              date_creation TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Profils_Seniors (
                                 id INT AUTO_INCREMENT PRIMARY KEY,
                                 id_utilisateur INT NOT NULL,
                                 competences TEXT,
                                 type_contrat VARCHAR(50),
                                 disponibilites VARCHAR(100),
                                 FOREIGN KEY (id_utilisateur) REFERENCES Utilisateurs(id) ON DELETE CASCADE
);


CREATE TABLE Profils_Recruteurs (
                                    id INT AUTO_INCREMENT PRIMARY KEY,
                                    id_utilisateur INT NOT NULL,
                                    entreprise VARCHAR(100),
                                    informations TEXT,
                                    FOREIGN KEY (id_utilisateur) REFERENCES Utilisateurs(id) ON DELETE CASCADE
);


CREATE TABLE Offres_Emploi (
                               id INT AUTO_INCREMENT PRIMARY KEY,
                               id_recruteur INT NOT NULL,
                               titre VARCHAR(100) NOT NULL,
                               description TEXT,
                               type_contrat VARCHAR(50),
                               date_publication TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                               FOREIGN KEY (id_recruteur) REFERENCES Profils_Recruteurs(id) ON DELETE CASCADE
);



CREATE TABLE Candidatures (
                              id INT AUTO_INCREMENT PRIMARY KEY,
                              id_senior INT NOT NULL,
                              id_offre INT NOT NULL,
                              statut ENUM('en_attente', 'acceptee', 'refusee') DEFAULT 'en_attente',
                              FOREIGN KEY (id_senior) REFERENCES Profils_Seniors(id) ON DELETE CASCADE,
                              FOREIGN KEY (id_offre) REFERENCES Offres_Emploi(id) ON DELETE CASCADE
);

CREATE TABLE Messages (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          expediteur_id INT NOT NULL,
                          destinataire_id INT NOT NULL,
                          contenu TEXT NOT NULL,
                          date_envoi TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          FOREIGN KEY (expediteur_id) REFERENCES Utilisateurs(id) ON DELETE CASCADE,
                          FOREIGN KEY (destinataire_id) REFERENCES Utilisateurs(id) ON DELETE CASCADE
);