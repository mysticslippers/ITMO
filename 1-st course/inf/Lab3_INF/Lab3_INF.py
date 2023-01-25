"""
Лабораторная работа №3
Михайлов Дмитрий Андреевич
Группа P3118
"""

import re


def Task60Points(number):
    eyes = [':', ';', 'X', '8', '=', '[']
    noses = ['-', '<', '-{', '<{']
    mouths = ['(', ')', 'O', '|', '\\', '/', 'P']
    print("Мой смайлик: " + ''.join([eyes[number % 6], noses[number % 4], mouths[number % 7]]))
    test_answers = []
    for i in range(5):
        test = input()
        test_answers.append(len(re.findall(r'=-{[)]', test)))
    print(' '.join([str(i) for i in test_answers]))


def AdditionalTask18Points():
    task = 'Уважаемые студенты! В эту субботу в 1500:00 17:00:01:15 17:00:99 15:0-1:10 планируется доп. занятие на 2 часа. То есть в 17:00:01 оно уже кончится.'
    print(re.sub(r"(?:((\s[0-1][0-9]:[0-5][0-9]:[0-5][0-9]\s)+|([2][0-4]:[0-5][0-9]:[0-5][0-9]))+|((\s[0-1][0-9]:[0-5][0-9]\s)+|(\s[2][0-4]:[0-5][0-9]\s)))", ' TBD ', task))


def AdditionalTask22Points():
    tests = ['google@niuitmo.ru', '.....@itmo.ru', '__@__@niuitmo.ru', 'google@niuitmo', 'ete_rnal_mar_tyr13579@gmail.com', 'ete.rnal.mar.tyr13579@gmail.com']
    for i in tests:
        if re.fullmatch((r'(?:(([a-zA-Z0-9][a-zA-Z0-9\.\_]+[a-zA-Z0-9])+|[_]+)[@]([a-zA-Z0-9]+[.]){1,2}[a-zA-Z]{2,})'), i):
            print(''.join(re.findall(r'@\w+.\w+', i)))
        else:
            print('Fail!')


isu = int(input())
print("Проверка основого задания на 60 баллов: ")
print(Task60Points(isu))
print(" ")
print("Проверка дополнительного задания на +18 баллов: ")
print(AdditionalTask18Points())
print(" ")
print("Проверка дополнительного задания на +22 балла: ")
print(AdditionalTask22Points())