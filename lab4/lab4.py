import time


class Keyboard:
    BLOCK = 47

    def __init__(self):
        self.symbols = ['`', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-', '=',  # SHIFT = 0, eng
                        'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', '[', ']', '\\',
                        'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', ';', '\'',
                        'z', 'x', 'c', 'v', 'b', 'n', 'm', ',', '.', '/',
                        '~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '_', '+',  # SHIFT = 1, eng
                        'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', '{', '}', '|',
                        'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', ':', '"',
                        'Z', 'X', 'C', 'V', 'B', 'N', 'M', '<', '>', '?',
                        'ё', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-', '=',  # SHIFT = 0, ru
                        'й', 'ц', 'у', 'к', 'е', 'н', 'г', 'ш', 'щ', 'з', 'х', 'ъ', '\\',
                        'ф', 'ы', 'в', 'а', 'п', 'р', 'о', 'л', 'д', 'ж', 'э',
                        'я', 'ч', 'с', 'м', 'и', 'т', 'ь', 'б', 'ю', '.',
                        'Ё', '!', '"', '№', ';', '%', ':', '?', '*', '(', ')', '_', '+',  # SHIFT = 1, ru
                        'Й', 'Ц', 'У', 'К', 'Е', 'Н', 'Г', 'Ш', 'Щ', 'З', 'Х', 'Ъ', '/',
                        'Ф', 'Ы', 'В', 'А', 'П', 'Р', 'О', 'Л', 'Д', 'Ж', 'Э',
                        'Я', 'Ч', 'С', 'М', 'И', 'Т', 'Ь', 'Б', 'Ю', ',']
        self.tmp_symbols = self.symbols.copy()
        self.management = ['shift', 'ctrl', 'alt']
        self.tmp_management = self.management.copy()
        self.workflow = []
        self.caps = False
        self.shift = False
        self.language = False  # 0 - eng, 1 - ru
        self.section = 2 * self.language + self.shift  # 1/4 x 47 symbols

    def caps_pressed(self):
        self.caps = not self.caps
        self.refresh_section()

    def shift_pressed(self):
        self.shift = not self.shift
        self.refresh_section()

    def switch_language(self):
        self.language = not self.language
        self.refresh_section()

    def refresh_section(self):
        self.section = 2 * self.language + (self.shift ^ self.caps)

    def press_key(self, key):
        if key.lower() == 'caps':
            self.caps_pressed()
        if key in self.symbols:
            time.sleep(1)
            print(self.build_key(key), end="")
            self.workflow.append(self.build_key(key))

    def build_key(self, key):
        if key in self.symbols:
            tmp = self.symbols[self.tmp_symbols.index(key) + self.BLOCK * self.section]
            return tmp
        return ''

    def press_combination(self, key1, key2, key3=""):
        if key1.lower() in self.management and key2.lower() in self.management and key3.lower() != "":
            time.sleep(1)
            print('[' + self.management[self.tmp_management.index(key1)] + '][' + self.management[self.tmp_management.index(key2)] + ']', end="")
            if key3 in self.symbols:
                print(self.build_key(key3), end="")
                self.workflow.append('[' + self.management[self.tmp_management.index(key1)] + ']' + '[' +
                                     self.management[self.tmp_management.index(key2)] + '] ' + self.build_key(key3))
            elif key3 in self.management:
                print(self.management[self.tmp_management.index(key3)], end="")
                self.workflow.append('[' + self.management[self.tmp_management.index(key1)] + ']' + '[' +
                    self.management[self.tmp_management.index(key2)] + '] ' + self.management[self.tmp_management.index(key3)])
        else:
            if key1.lower() == 'alt' and key2.lower() == 'shift':
                self.switch_language()
            if key1.lower() == 'shift' and key2 in self.symbols:
                self.shift_pressed()
                self.press_key(key2)
                self.workflow.append(self.build_key(key2))
                self.shift_pressed()
            if (key1.lower() == 'ctrl' or key1.lower() == 'alt') and key2 in self.symbols:
                time.sleep(1)
                print(' [' + key1 + ']' + self.build_key(key2), end="")
                self.workflow.append('[' + key1 + '] ' + self.build_key(key2))

    def undo(self):
        last_action = self.workflow.pop()
        for i in range(len(last_action)):
            print('\b \b', end="")

    def rename_key(self, old, new):  # переназначение клавиши
        if old in self.symbols and new in self.symbols:
            tmp_old = self.tmp_symbols.index(self.build_key(old))
            tmp_new = self.tmp_symbols.index(self.build_key(new))
            self.tmp_symbols[tmp_old], self.tmp_symbols[tmp_new] = self.tmp_symbols[tmp_new], self.tmp_symbols[tmp_old]
            self.workflow_reload(old, new)

    def rename_combination(self, old, new):  # переназначение клавиш для комбинации
        if old in self.management and new in self.management:
            tmp_old = self.tmp_management.index(old)
            tmp_new = self.tmp_management.index(new)
            self.tmp_management[tmp_new], self.tmp_management[tmp_old] = self.tmp_management[tmp_old], self.tmp_management[tmp_new]
            self.workflow_reload(old, new)

    def workflow_print(self):
        print(self.workflow)

    def workflow_reload(self, old, new):
        if len(new) == 1:
            for i in range(0, len(self.workflow)):
                if self.workflow[i] is old:
                    self.workflow[i] = new
        else:
            for i in range(0, len(self.workflow)):
                if old in self.workflow[i]:
                    self.workflow[i] = self.workflow[i].replace(old, new)


def main():
    kb = Keyboard()

    kb.press_key('q')
    # kb.press_key('w')
    # kb.press_key('e')
    # kb.press_combination('shift', 'a')
    kb.press_combination('shift', 's')
    # kb.press_combination('shift', 'd')

    kb.press_key('caps')

    # kb.press_key('a')
    kb.press_key('s')
    # kb.press_key('d')
    # kb.press_combination('shift', 'a')
    kb.press_combination('shift', 's')
    # kb.press_combination('shift', 'd')

    kb.press_combination('alt', 'shift')

    kb.press_key('q')
    # kb.press_key('w')
    # kb.press_key('e')
    # kb.press_combination('shift', 'a')
    kb.press_combination('shift', 's')
    # kb.press_combination('shift', 'd')

    kb.press_key('caps')

    kb.press_key('q')
    # kb.press_key('w')
    # kb.press_key('e')
    # kb.press_combination('shift', 'a')
    kb.press_combination('shift', 's')
    # kb.press_combination('shift', 'd')

    kb.press_combination('alt', 'z')
    kb.undo()
    kb.press_combination('alt', 'shift')
    kb.press_key('x')
    print()
    kb.workflow_print()

    kb.rename_key('x', 'c')
    kb.press_key('x')
    print()
    kb.workflow_print()

    kb.press_combination('alt', 'shift', 'a')
    print()
    kb.workflow_print()

    kb.rename_combination('alt', 'ctrl')
    kb.press_combination('alt', 'shift', 'a')
    print()
    kb.workflow_print()


if __name__ == '__main__':
    main()
