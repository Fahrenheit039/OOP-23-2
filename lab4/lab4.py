import time
from abc import ABC, abstractmethod


class Command(ABC):
    @abstractmethod
    def exec(self):
        print("Выполнено действие", self.__class__.__name__)

    @abstractmethod
    def undo(self):
        print("Отменено действие", self.__class__.__name__)
        pass


class Action1(Command):
    def exec(self):
        super().exec()

    def undo(self):
        super().undo()


class Action2(Command):
    def exec(self):
        super().exec()

    def undo(self):
        super().undo()


class Action3(Command):
    def exec(self):
        super().exec()

    def undo(self):
        super().undo()


class VirtualKeyboard:
    def __init__(self):
        self.actions = {}
        self.history = []

    def assign_action(self, key, action):
        self.actions[key] = action
        print("На клавишу", key, "назначено действие", action.__class__.__name__)

    def press_key(self, key):
        if key in self.actions:
            action = self.actions[key]
            print("Нажата клавиша", key, ", ", end="")
            action.exec()
            self.history.append(action)

    def undo_last_action(self):
        if self.history:
            print("до:", self.history)
            self.history.pop().undo()
            print("после:", self.history)


if __name__ == '__main__':
    vkb = VirtualKeyboard()

    vkb.assign_action("F1", Action1())
    vkb.assign_action("Ctrl+Alt+X", Action2())
    vkb.assign_action("Shift+Z", Action3())

    vkb.press_key("F1")
    time.sleep(1)

    vkb.press_key("Ctrl+Alt+X")
    time.sleep(1)

    vkb.press_key("Shift+Z")
    time.sleep(1)

    vkb.undo_last_action()
    time.sleep(1)

    vkb.assign_action("F1", Action2())
    vkb.assign_action("Ctrl+Alt+X", Action3())
    vkb.assign_action("Shift+Z", Action1())

    vkb.undo_last_action()

    vkb.press_key("F1")
    time.sleep(1)

    vkb.press_key("Ctrl+Alt+X")
    time.sleep(1)

    vkb.press_key("Shift+Z")
    time.sleep(1)

    vkb = VirtualKeyboard()

    vkb.press_key("F1")
    time.sleep(1)

    vkb.press_key("Ctrl+Alt+X")
    time.sleep(1)

    vkb.press_key("Shift+Z")
    time.sleep(1)
