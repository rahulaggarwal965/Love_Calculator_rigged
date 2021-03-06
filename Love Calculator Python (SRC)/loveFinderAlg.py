
# Function for adding the rigged name pairs to the "rigged" list ------


def add_name_pair_to_rigged_lists(string_name_1, string_name_2):
    global rigged_name_list_1
    global rigged_name_list_2
    rigged_name_list_1.append(string_name_1.lower())
    rigged_name_list_2.append(string_name_2.lower())


def compare_lists(list1, list2, comp_list):
    percentage_list = [0, 0, 0, 0, 0]
    for x in range(0, len(list1)):
        for y in range(0, len(comp_list)):
            if list1[x] == comp_list[y]:
                percentage_list[y] += 1
            y += 1
        x += 1
    for x in range(0, len(list2)):
        for y in range(0, len(comp_list)):
            if list2[x] == comp_list[y]:
                percentage_list[y] += 1
            y += 1
        x += 1
    return percentage_list


def convert_list_to_percent(p_list):
    string_local_compatibility = ''.join(str(e) for e in p_list)
    while len(string_local_compatibility) > 2:
        list_local_compatibility = list(string_local_compatibility)
        list_local_compatibility = list(map(int, list_local_compatibility))
        for a in range(0, (len(list_local_compatibility) - 1)):
            list_local_compatibility[a] += list_local_compatibility[a + 1]
            a += 1
        del list_local_compatibility[-1]
        string_local_compatibility = ''.join(str(e) for e in list_local_compatibility)
    return string_local_compatibility


def assign_love_values(compatibility):
    temp_compatibility = round(compatibility, -1)
    values_map = {0: 'Are you serious?',
                  10: 'Do they even know each other\'s names?',
                  20: 'Their relationship is unsubstantial and flimsy, completely unconvincing.',
                  30: 'Give it another year.... Then maybe I\'ll reconsider.',
                  40: 'Dubious... but possible. ',
                  50: 'Maybe... just maybe...',
                  60: 'At least get them to talk. See what happens.',
                  70: 'Set em\' up on a blind date. It\'ll probably work out, but if it doesn\'t, at least it\'ll be hilarious!',
                  80: 'Sweet, sweet romance. Man, I remember the good ol\' days.',
                  90: 'Get her some chocolates on Valentine\'s day, and you\'re set for life.',
                  100: 'Ahhh. A rare case of "true love." Cherish it, and never forget it.'}
    value = values_map[temp_compatibility]
    return value

# ADD RIGGED NAME PAIRS HERE -----
# Name 1
rigged_name_list_1 = []
# Name 2
rigged_name_list_2 = []
# ------
add_name_pair_to_rigged_lists('ashwin', 'java')
add_name_pair_to_rigged_lists('ashwin', 'connie')
add_name_pair_to_rigged_lists('tim', 'amy')
# ADD RIGGED NAME PAIRS HERE -----

compare_string = "loves"
compare_list = list(compare_string)

input = open('output.txt', 'r')
name1 = input.readline()
name2 = input.readline()
input.close()

name1 = name1.replace('\n', '')
name1 = name1.replace(' ', '')
name2 = name2.replace('\n', '')
name2 = name2.replace(' ', '')
name1_list = list(name1)
name2_list = list(name2)

global_percentage_list = compare_lists(name1_list, name2_list, compare_list)
string_global_compatibility = convert_list_to_percent(global_percentage_list)
int_global_compatibility = int(string_global_compatibility)

if name1.lower() in rigged_name_list_1 and name2.lower() in rigged_name_list_2:
    for x in range(0, len(rigged_name_list_1)):
        if rigged_name_list_1[x] == name1.lower() and rigged_name_list_2[x] == name2.lower():
            int_global_compatibility = 100
        x += 1
elif name1.lower() in rigged_name_list_2 and name2.lower() in rigged_name_list_1:
    for x in range(0, len(rigged_name_list_1)):
        if rigged_name_list_2[x] == name1.lower() and rigged_name_list_1[x] == name2.lower():
            int_global_compatibility = 100

global_para_value = assign_love_values(int_global_compatibility)

output = open('input.txt', 'w')
output.write(str(int_global_compatibility))
output.close()

# sys.stdout.write("%s and %s are %d percent compatible. %s" % (name1.capitalize(), name2.capitalize(), int_global_compatibility, global_para_value))
