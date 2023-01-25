import sys

sys.setrecursionlimit(10000)

def FillingBlocks(message):
    f1 = open('До обработки.txt', 'w')
    if len(message) % 7 != 0:
        message = message[::-1]
        message += ''.join([str(i * 0) for i in range((int(len(message) / 7) + 1) * 7 - len(message))])
        message = message[::-1]
    else:
        pass
    countOfBlocks = len(message) // 7
    tmp = 0
    word = ''
    while countOfBlocks != 0:
        if tmp == 7:
            f1.write(word + '\n')
            word = ''
            tmp = 0
            countOfBlocks -= 1
            message = message[7:]
        else:
            word += message[tmp]
            tmp += 1
    f1.close()


def DecodedBlocks():
    messages = []
    with open('До обработки.txt', 'r') as f1:
        messages = f1.read().splitlines()
    f2 = open('После обработки.txt', 'w')

    for message in messages:
        i, r = [], []
        for k in range(len(message)):
            if str(k) in '013':
                r.append(int(message[k]))
            else:
                i.append(int(message[k]))
        si = [r[0] ^ i[0] ^ i[1] ^ i[3], r[1] ^ i[0] ^ i[2] ^ i[3], r[2] ^ i[1] ^ i[2] ^ i[3]]
        si.reverse()
        s = ''.join([str(k) for k in si])
        if s != '000':
            ind = 0
            s = s[::-1]
            for k in range(len(s)):
                ind += int(s[k]) * 2 ** k
            if str(ind) in '124':
                if r[ind // 2] % 2 == 0:
                    r[ind // 2] = 1
                else:
                    r[ind // 2] = 0
            elif ind == 3:
                if i[0] % 2 == 0:
                    i[0] = 1
                else:
                    i[0] = 0
            elif ind == 5:
                if i[1] % 2 == 0:
                    i[1] = 1
                else:
                    i[1] = 0
            elif ind == 6:
                if i[2] % 2 == 0:
                    i[2] = 1
                else:
                    i[2] = 0
            else:
                if i[3] % 2 == 0:
                    i[3] = 1
                else:
                    i[3] = 0
            f2.write(''.join([str(k) for k in r[:2]]) + str(i[0]) + str(r[2]) + ''.join([str(k) for k in i[1:]]) + '\t' + 'Ошибка в позиции: ' + str(ind) + '\n')
        else:
            f2.write(message + '\t' + 'Ошибки нет!' + '\n')
    f1.close()
    f2.close()


message = input()
FillingBlocks(message)
print('Готовы к декодированию?')
while True:
    answer = input().lower()
    if answer in 'гопоехалистартуемда':
        DecodedBlocks()
        break
