"""
Лабораторная работа №5
Михайлов Дмитрий Андреевич
Группа P3118
"""


def AdditionalTask15():
    import matplotlib.pyplot as plt
    import pandas as pd

    data = pd.read_csv("AdditionalTask13.csv", sep=";")
    data.boxplot()

    plt.legend(['Открытие', 'Максимум', 'Минимум', 'Закрытие'])
    plt.xticks(rotation=90)
    plt.show()


AdditionalTask15()
