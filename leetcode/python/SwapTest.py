def swap(x, y):
    print("begin swap")
    print(x, " <- x, y -> ", y)
    tmp = x
    x = y
    y = tmp
    print(x, " <- x, y -> ", y)
    print("end swap")

def swap2(x, y):
    tmp = x
    x = y
    y = tmp
    return x,y

x = 100
y = 200
print(x, " <- x, y -> ", y)
swap(x, y)
print("swap 1: ", x, " <- x, y -> ", y)
x, y = swap2(x, y)
print("swap 2: ", x, " <- x, y -> ", y)

