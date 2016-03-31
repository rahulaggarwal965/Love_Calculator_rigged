import sys


def comparelists(list1, list2):
    local_compatibility = 0
    if len(list1) < len(list2):
        for x in range(0, len(list1)):
            if list1[x] == list2[x]:
                local_compatibility += 15
            x += 1
    elif len(list2) < len(list1):
        for x in range(0, len(list2)):
            if list2[x] == list1[x]:
                local_compatibility += 15
            x += 1
    else:
        local_compatibility += 20
        for x in range(0, len(list1)):
            if list1[x] == list2[x]:
                local_compatibility += 15
            x += 1
    return local_compatibility

print("What is name 1?")
name1 = sys.stdin.readline()
print("What is name 2?")
name2 = sys.stdin.readline()

name1list = list(name1)
name2list = list(name2)

del name1list[-1]
del name2list[-1]

global_compatibility = comparelists(name1list, name2list)

if global_compatibility > 100:
    global_compatibility = 100

# Debug -------------------
print(name1list, name2list)
print(global_compatibility)
# Debug -------------------

print("%s and %s are %d percent compatible" % (name1, name2, global_compatibility), end="")
