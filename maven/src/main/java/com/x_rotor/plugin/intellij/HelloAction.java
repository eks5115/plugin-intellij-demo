package com.x_rotor.plugin.intellij;

/**
 * Created by chensen on 2017/7/5.
 */
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;

public class HelloAction extends AnAction {

    public void actionPerformed(AnActionEvent event) {
        Project project = event.getData(PlatformDataKeys.PROJECT);
        String userName = this.askForName(project);
        this.sayHello(project, userName);
    }

    private String askForName(Project project) {
        return Messages.showInputDialog(project, "What is your name?", "Input Your Name", Messages.getQuestionIcon());
    }

    private void sayHello(Project project, String userName) {
        Messages.showMessageDialog(project, String.format("Hello, %s!\n Welcome to PubEditor.", new Object[]{userName}), "Information", Messages.getInformationIcon());
    }
}
