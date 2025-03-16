/* Criando um Clone do BuzzFeed com Angular */

// 1. Instale o Angular CLI, caso ainda não tenha:
// npm install -g @angular/cli

// 2. Crie um novo projeto Angular:
// ng new buzzfeed-clone

// 3. Navegue até a pasta do projeto:
// cd buzzfeed-clone

// 4. Crie os componentes necessários:
// ng generate component components/header
// ng generate component components/footer
// ng generate component components/quiz
// ng generate component components/result

// 5. Crie um serviço para manipular os quizzes:
// ng generate service services/quiz

// 6. Defina o modelo de quiz em `src/app/models/quiz.ts`
export interface Quiz {
    question: string;
    options: { answer: string; score: number }[];
}

// 7. Implemente o serviço `QuizService` em `src/app/services/quiz.service.ts`
import { Injectable } from '@angular/core';
        import { Quiz } from '../models/quiz';
        import { Observable, of } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class QuizService {
    private quizzes: Quiz[] = [
    {
        question: 'Qual seu animal favorito?',
                options: [
        { answer: 'Cachorro', score: 10 },
        { answer: 'Gato', score: 20 },
        { answer: 'Pássaro', score: 30 }
      ]
    },
    {
        question: 'Qual sua cor preferida?',
                options: [
        { answer: 'Vermelho', score: 10 },
        { answer: 'Azul', score: 20 },
        { answer: 'Verde', score: 30 }
      ]
    }
  ];

    getQuizzes(): Observable<Quiz[]> {
        return of(this.quizzes);
    }
}

// 8. Configure o roteamento em `src/app/app-routing.module.ts`
import { NgModule } from '@angular/core';
        import { RouterModule, Routes } from '@angular/router';
        import { QuizComponent } from './components/quiz/quiz.component';
        import { ResultComponent } from './components/result/result.component';

        const routes: Routes = [
        { path: '', component: QuizComponent },
        { path: 'result', component: ResultComponent }
        ];

@NgModule({
        imports: [RouterModule.forRoot(routes)],
exports: [RouterModule]
        })
export class AppRoutingModule { }

// 9. Rode o projeto localmente:
// ng serve --open
