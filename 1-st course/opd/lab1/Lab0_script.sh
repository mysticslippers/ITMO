# !/bin/bash

mkdir lab0
cd lab0
mkdir -m 744 bellsprout3 duskull6 feraligatr8
cd bellsprout3
echo -e "Возможности Overland=6  Surface=4 Jump=3 Power=2"\n"Intelligence=3">bagon
echo -e "weigth=62.8 height=51.0"\n"def=6">wobbuffet
mkdir vulpix slakoth
cd ..
cd duskull6
echo -e "Способности Focus Energy Quick Attack Wing Attack"\n"Double Team Endeavor Aerial Ace Agility AIr Slash">swellow
echo -e "Тип Покемона"\n"PSYCHIC NONE">espeon
echo -e "Ходы Ancientpower Body Slam Bug Bite"\n"Double-Edge Earth Power Fury Cutter Iron Defense Knock Off Mud-Slap"/n"Sleep Talk Snore Stealth Rock String Shot">anorith
echo -e "Развитые способности Unaware">quagsire
echo -e "Способности Haunt Blaze Flash Fire"\n"Flame Body">lampent
cd ..
cd feraligatr8
mkdir -m 744 omastar rapidash ninjask
echo -e "weigth=5.5 heigth=12.0 atk=5"\n"def=7">sewaddle
echo "satk=6 sdef=8 spd=8">garbodor
cd ..
echo  -e "Возможности Overland=6"\n"Surface=6 Jump=6 Power=3 Intelligence=4">grumpig5
echo -e "Способности Thunder Wave Leer Howl Quick Attack Spark Odor Sleuth Bite Thunder"\n"Fang Roar Discharge Charge Wild Charge Thunder">manectric3
echo -e "weigth=5.5"\n"height=16.0 atk=6 def=4">torchic0


cd bellsprout3
chmod 622 bagon
chmod 044 wobbuffet
chmod 373 vulpix
chmod 373 slakoth
cd ..
chmod 317 bellsprout3
cd duskull6
chmod 004 swellow
chmod 444 espeon
chmod 600 anorith
chmod 044 quagsire
chmod 600 lampent
cd ..
chmod 576 duskull6
cd feraligatr8
chmod 770 omastar
chmod 640 sewaddle
chmod 312 ninjask
chmod 573 rapidash
chmod 044 garbodor
cd ..
chmod 312 feraligatr8
chmod 600 grumpig5
chmod 060 manectric3
chmod 062 torchic0

#3
chmod 744 duskull6 feraligatr8 bellsprout3
cd duskull6
chmod 744 quagsire
cd ..
cat ./duskull6/anorith ./duskull6/quagsire>./torchic0_54
cp -r ./feraligatr8 ./feraligatr8/rapidash/
ln ./grumpig5 ./duskull6/anorithgrumpig
ln -s ./manectric3 ./duskull6/espeonmanectric
cat ./grumpig5>./bellsprout3/bagongrumpig
cd feraligatr8
chmod 773 rapidash
cd ..
cp grumpig5 ./feraligatr8/rapidash/
ln -s ./feraligatr8 ./Copy_16

#4
cd bellsprout3
chmod 744 quagsire
cd ..
((wc -m espeon && wc -m quagsire && wc -m anorith) | sort -n) 2>/dev/null
(ls -lR **/*ga* | sort -k2 n) 2>/tmp/fileErr
(ls -lR | grep 3$ | sort -k9) 2>/dev/null
(ls -lR | grep t$ | wc -m | sort -rn) 2>&1
(cat -n ./feraligatr8/* | grep -i e$)
cd duskull6
chmod 704 swellow
cd ..
(cat ./duskull6/* | grep -i "dy")

#5
rm -f torchic0
rm -f ./bellsprout3/wobbuffet
rm -f ./Copy_*
rm -f ./duskull6/anorithgrumpig
rm -R duskull6
cd bellsprout3
chmod 773 vulpix
cd ..
rm -R ./bellsprout3/vulpix