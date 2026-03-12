create database superflow_db;
use superflow_db;

CREATE TABLE fournisseurs (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    ville VARCHAR(100),
    telephone VARCHAR(20)
);

CREATE TABLE produits (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    categorie VARCHAR(50),
    prix DECIMAL(10, 2),
    quantite_stock INT,
	FOREIGN KEY (fournisseur_id) REFERENCES fournisseur(id)
);

CREATE TABLE mouvements (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    type_mouvement ENUM('ENTREE', 'SORTIE') NOT NULL,
    quantite INT NOT NULL,
    date_mouvement DATETIME DEFAULT CURRENT_TIMESTAMP,
    produit_id BIGINT,
    FOREIGN KEY (produit_id) REFERENCES produit(id)
);
SELECT * FROM produit;
