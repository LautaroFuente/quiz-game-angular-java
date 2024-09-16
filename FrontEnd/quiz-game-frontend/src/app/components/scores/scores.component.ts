import { Component } from '@angular/core';
import { ScoresServiceService } from '../../services/scores-service.service';
import { Score } from '../../interfaces/Score.interface';

@Component({
  selector: 'app-scores',
  standalone: true,
  imports: [],
  templateUrl: './scores.component.html',
  styleUrl: './scores.component.css',
})
export class ScoresComponent {
  scores!: Score[];

  constructor(private scoreService: ScoresServiceService) {
    this.scoreService.getScores().subscribe(
      (response) => {
        console.log('Informacion obtenida', response);
        this.scores = response;
      },
      (error) => console.log(`Error`, error)
    );
  }
}
