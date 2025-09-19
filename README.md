# Gestion des Réservations d'Hôtels

## Description

Une application console Java pour la gestion des réservations d’hôtels, conçue pour l’apprentissage de la POO et des
bonnes pratiques de développement.

## Fonctionnalités

- Authentification sécurisée (inscription, connexion, modification du profil, changement de mot de passe)
- Gestion des hôtels (création, modification, suppression, consultation, filtrage par disponibilité)
- Réservation et annulation de chambres
- Historique des réservations trié par date
- Validation des entrées utilisateur

## Structure du projet

- `domain/` : Entités principales (Client, Hotel, Reservation)
- `repository/` : Interfaces et implémentations en mémoire
- `service/` : Logique métier (authentification, hôtels, réservations)
- `ui/` : Menus et interface console
- `utils/` : Outils de validation et saisie

## Installation & Exécution

1. Cloner le dépôt :
   ```bash
   git clone https://github.com/Souhail-imarraine/gestion_reservations_hotels.git
   ```
2. Compiler le projet :
   ```bash
   javac -d bin src/**/*.java
   ```
3. Lancer l’application :
   ```bash
   java -cp bin Main
   ```

## Usage

Suivez les instructions affichées dans la console pour naviguer dans les menus, créer des hôtels, réserver des chambres,
et gérer votre profil.

## Auteur

Souhail Imarraine

## Licence

Ce projet est fourni à des fins pédagogiques.