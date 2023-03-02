SELECT hunter.id, hunter.name, hunter.monster_id, monster.id, monster.name, monster.shelter_id, shelter.id, shelter.name
       FROM hunter INNER JOIN monster on monster.id = hunter.monster_id
           INNER JOIN shelter on (monster.shelter_id = shelter.id) AND (shelter.name = 'Болото')