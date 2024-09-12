import { Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { GameComponent } from './components/game/game.component';
import { ScoresComponent } from './components/scores/scores.component';
import { InstructionsComponent } from './components/instructions/instructions.component';

export const routes: Routes = [
    { path: '', component: HomeComponent },
    { path: 'game', component: GameComponent },
    { path: 'scores', component: ScoresComponent },
    { path: 'instructions', component: InstructionsComponent },

];
