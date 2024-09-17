import { Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { GameComponent } from './components/game/game.component';
import { ScoresComponent } from './components/scores/scores.component';
import { InstructionsComponent } from './components/instructions/instructions.component';
import { RegisterComponent } from './components/register/register.component';
import { SelectDifficultyComponent } from './components/select-difficulty/select-difficulty.component';
import { EndgameComponent } from './components/endgame/endgame.component';

export const routes: Routes = [
    { path: '', component: HomeComponent },
    { path: 'game', component: GameComponent },
    { path: 'scores', component: ScoresComponent },
    { path: 'instructions', component: InstructionsComponent },
    { path: 'register', component: RegisterComponent },
    { path: 'difficulty', component: SelectDifficultyComponent },
    { path: 'endgame', component: EndgameComponent },

];
